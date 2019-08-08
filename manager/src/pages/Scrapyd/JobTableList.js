import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({}) => ({}))
@Form.create()
class JobTableList extends PureComponent {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('scrapyd/jobs'));
  }

  render() {
    return (
      <PageHeaderWrapper title="任务列表">
        <Card bordered={false} />
      </PageHeaderWrapper>
    );
  }
}

export default JobTableList;
