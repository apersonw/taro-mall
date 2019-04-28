import React, { Fragment, PureComponent } from 'react';
import { connect } from 'dva';
import router from 'umi/router';
import { Avatar, Button, Card, Divider, Dropdown, Form, Icon, List, Menu } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import styles from './GoodsTableList.less';
import moment from 'moment';
import fetchPage from '../../utils/fetchPage';

/* eslint react/no-multi-comp:0 */
@connect(({ pages, pagination, loading }) => ({
  goodsList: pages['goodsList'],
  pagination: pagination['goodsList'],
  loading: loading.models.pages,
}))
@Form.create()
class GoodsTableList extends PureComponent {
  componentDidMount() {
    fetchPage('goods', { page: 1 });
  }

  render() {
    const { goodsList, loading, pagination } = this.props;
    const ListContent = ({ data: { coverPrice, createdAt, percent, status } }) => (
      <div className={styles.listContent}>
        <div className={styles.listContentItem}>
          <span>封面价</span>
          <p>¥{(coverPrice / 100).toFixed(2)}</p>
        </div>
        <div className={styles.listContentItem}>
          <span>创建日期</span>
          <p>{moment(createdAt).format('YYYY-MM-DD HH:mm')}</p>
        </div>
      </div>
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
      <PageHeaderWrapper title="商品列表">
        <Card bordered={false}>
          <Button
            type="dashed"
            style={{ width: '100%', marginBottom: 8 }}
            icon="plus"
            onClick={() => router.push('/goods/goodsSaveForm')}
          >
            添加
          </Button>
          <List
            size="large"
            rowKey="id"
            loading={loading}
            pagination={{
              ...pagination,
              onChange: (page, pageSize) => fetchPage('goods', { page, pageSize }),
            }}
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
                  </a>,
                  <MoreBtn current={item} />,
                ]}
              >
                <List.Item.Meta
                  avatar={<img className={styles.thumb} src={item.thumb.key} />}
                  title={item.name}
                />
                <ListContent data={item} />
              </List.Item>
            )}
          />
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default GoodsTableList;
