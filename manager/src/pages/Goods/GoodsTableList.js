import React, { Fragment, PureComponent } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { Avatar, Badge, Button, Card, Divider, Dropdown, Form, Icon, List, Menu, Progress } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import StandardTable from '@/components/StandardTable';

import styles from './GoodsTableList.less';
import moment from 'moment';
import { findDOMNode } from 'react-dom';
import fetchPage from '../../utils/fetchPage';

const statusMap = ['default', 'processing', 'success', 'error'];

/* eslint react/no-multi-comp:0 */
@connect(({ pages, pagination, loading }) => ({
  goodsList: pages['goodsList'],
  pagination: pagination['goodsList'],
  loading: loading.models.pages,
}))
@Form.create()
class GoodsTableList extends PureComponent {
  componentDidMount() {
    fetchPage('goods', { page: 0 });
  }

  state = {
    selectedRows: [],
  };

  columns = [
    {
      title: 'ID',
      dataIndex: 'id',
    },
    {
      title: '名称',
      dataIndex: 'name',
    },
    {
      title: '缩略图',
      dataIndex: 'thumb.url',
    },
    {
      title: '描述',
      dataIndex: 'desc',
    },
    {
      title: '类目Id',
      dataIndex: 'categoryId',
    },
    {
      title: '品牌Id',
      dataIndex: 'brandId',
    },
    {
      title: '类型', //虚拟和实物
      dataIndex: 'type',
    },
    {
      title: '状态',
      dataIndex: 'status',
    },
    {
      title: '超售',
      dataIndex: 'excess',
    },
    {
      title: '优先级',
      dataIndex: 'priority',
    },
    {
      title: '创建日期',
      dataIndex: 'createDate',
      render: val => <span >{moment(val).format('YYYY-MM-DD HH:mm:ss')}</span >,
    },
    {
      title: '操作',
      render: (text, record) => (
        <Fragment >
          <a onClick={() => this.handleUpdateModalVisible(true, record)} >编辑</a >
          <Divider type="vertical" />
          <a href="" >删除</a >
        </Fragment >
      ),
    },
  ];

  handleSelectRows = rows => {
    this.setState({
      selectedRows: rows,
    });
  };

  handleStandardTableChange = (pagination, filtersArg, sorter) => {
    const { dispatch } = this.props;
    const { formValues } = this.state;

    const filters = Object.keys(filtersArg).reduce((obj, key) => {
      const newObj = { ...obj };
      newObj[key] = getValue(filtersArg[key]);
      return newObj;
    }, {});

    const params = {
      currentPage: pagination.current,
      pageSize: pagination.pageSize,
      ...formValues,
      ...filters,
    };
    if (sorter.field) {
      params.sorter = `${sorter.field}_${sorter.order}`;
    }

    dispatch({
      type: 'goods/fetch',
      payload: params,
    });
  };

  render() {
    const { goodsList, loading, pagination } = this.props;
    const ListContent = ({ data: { owner, createdAt, percent, status } }) => (
      <div className={styles.listContent} >
        <div className={styles.listContentItem} >
          <span >Owner</span >
          <p >{owner}</p >
        </div >
        <div className={styles.listContentItem} >
          <span >开始时间</span >
          <p >{moment(createdAt).format('YYYY-MM-DD HH:mm')}</p >
        </div >
        <div className={styles.listContentItem} >
          <Progress percent={percent} status={status} strokeWidth={6} style={{ width: 180 }} />
        </div >
      </div >
    );
    const MoreBtn = props => (
      <Dropdown
        overlay={
          <Menu onClick={({ key }) => editAndDelete(key, props.current)}>
            <Menu.Item key="edit">编辑</Menu.Item>
            <Menu.Item key="delete">删除</Menu.Item>
          </Menu>
        }
      >
        <a>
          更多 <Icon type="down" />
        </a>
      </Dropdown>
    );
    return (
      <PageHeaderWrapper title="商品列表" >
        <Card bordered={false} >
          <Button
            type="dashed"
            style={{ width: '100%', marginBottom: 8 }}
            icon="plus"
            onClick={() => router.push('/goods/goodsSaveForm')}
          >
            添加
          </Button >
          <List
            size="large"
            rowKey="id"
            loading={loading}
            pagination={pagination}
            dataSource={goodsList}
            renderItem={item => (
              <List.Item
                actions={[
                  <a
                    onClick={e => {
                      e.preventDefault();
                      this.showEditModal(item);
                    }}
                  >
                    编辑
                  </a >,
                  <MoreBtn current={item} />,
                ]}
              >
                <List.Item.Meta
                  avatar={<Avatar src={item.logo} shape="square" size="large" />}
                  title={<a href={item.href} >{item.title}</a >}
                  description={item.subDescription}
                />
                <ListContent data={item} />
              </List.Item >
            )}
          />
        </Card >
      </PageHeaderWrapper >
    );
  }
}

export default GoodsTableList;
