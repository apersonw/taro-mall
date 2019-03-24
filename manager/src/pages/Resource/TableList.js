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
      <PageHeaderWrapper title="资源列表">
        <Card bordered={false}>
          <div className={styles.tableList}>资源列表</div>
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default TableList;
