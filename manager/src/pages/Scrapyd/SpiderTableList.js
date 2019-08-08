import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({ scrapyd }) => ({
  ...scrapyd,
}))
@Form.create()
class SpiderTableList extends PureComponent {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('scrapyd/spiders'));
  }

  render() {
    const { spiders = [] } = this.props;
    return (
      <PageHeaderWrapper title="爬虫列表">
        <Card bordered={false}>
          {spiders.map(spider => (
            <div>{spider}</div>
          ))}
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default SpiderTableList;
