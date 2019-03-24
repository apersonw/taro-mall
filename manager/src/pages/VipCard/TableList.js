import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './TableList.less';

/* eslint react/no-multi-comp:0 */
@connect(({ loading }) => ({
  loading: loading.models.rule,
}))
@Form.create()
class TableList extends PureComponent {
  render() {
    return (
      <PageHeaderWrapper title="会员管理">
        <Card bordered={false}>
          <div className={styles.tableList}>会员管理</div>
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default TableList;
