import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';

import styles from './BrandTableList.less';

/* eslint react/no-multi-comp:0 */
@connect(({ loading }) => ({
  loading: loading.models.rule,
}))
@Form.create()
class BrandTableList extends PureComponent {
  render() {
    return (
      <PageHeaderWrapper title="品牌列表">
        <Card bordered={false}>
          <div className={styles.BrandTableList}>品牌列表</div>
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default BrandTableList;
