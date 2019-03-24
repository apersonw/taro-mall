import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './CouponTableList.less';

/* eslint react/no-multi-comp:0 */
@connect(({ loading }) => ({
  loading: loading.models.rule,
}))
@Form.create()
class CouponTableList extends PureComponent {
  render() {
    return (
      <PageHeaderWrapper title="券码管理">
        <Card bordered={false}>
          <div className={styles.CouponTableList}>券码管理</div>
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default CouponTableList;
