import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({ scrapyd }) => ({
  ...scrapyd,
}))
@Form.create()
class ProjectTableList extends PureComponent {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('scrapyd/projects'));
  }

  render() {
    const { projects = [] } = this.props;
    console.log(projects);
    return (
      <PageHeaderWrapper title="项目列表">
        <Card bordered={false}>
          {projects.map(project => (
            <div>{project}</div>
          ))}
        </Card>
      </PageHeaderWrapper>
    );
  }
}

export default ProjectTableList;
