import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({ loading }) => ({
  loading: loading.models.pages,
}))
@Form.create()
class ProjectTableList extends PureComponent {
  componentDidMount() {
    console.log('加载project');
    const { dispatch } = this.props;
    debugger;
    dispatch(action('scrapyd/projects'));
  }

  render() {
    return (
      <PageHeaderWrapper title="项目列表">
        <Card bordered={false} />
      </PageHeaderWrapper>
    );
  }
}

export default ProjectTableList;
