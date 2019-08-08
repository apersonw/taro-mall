import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({ loading }) => ({
  loading: loading.models.pages,
}))
@Form.create()
class SpiderTableList extends PureComponent {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('scrapyd/spiders'));
  }

  render() {
    return (
      <PageHeaderWrapper title="爬虫列表">
        <Card bordered={false} />
      </PageHeaderWrapper>
    );
  }
}

export default SpiderTableList;
