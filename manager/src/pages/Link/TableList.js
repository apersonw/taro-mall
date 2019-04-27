import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Avatar, Card, Form, List } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import fetchPage from '../../utils/fetchPage';

import styles from './TableList.less';

/* eslint react/no-multi-comp:0 */
@connect(({ pagination, pages, loading }) => ({
  loading: loading.models.pages,
  pagination: pagination.linkLocations,
  linkLocations: pages.linkLocations,
}))
@Form.create()
class TableList extends PureComponent {
  componentDidMount() {
    fetchPage('linkLocation', { page: 0 });
  }

  render() {
    const { loading, pagination, linkLocations } = this.props;
    return (
      <PageHeaderWrapper title="链接列表" >
        <Card bordered={false} >
          <List
            size="large"
            rowKey="id"
            loading={loading}
            pagination={pagination}
            dataSource={linkLocations}
            renderItem={item => (
              <List.Item
                actions={[
                  <a >编辑</a >,
                ]}
              >
              </List.Item >
            )}
          />
        </Card >
      </PageHeaderWrapper >
    );
  }
}

export default TableList;
