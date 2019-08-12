import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({}) => ({}))
@Form.create()
class PermissionTableList extends PureComponent {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('permission/permissions'));
  }

  render() {
    return (
      <PageHeaderWrapper title="权限列表">
        <Card bordered={false} />
      </PageHeaderWrapper>
    );
  }
}

export default PermissionTableList;
