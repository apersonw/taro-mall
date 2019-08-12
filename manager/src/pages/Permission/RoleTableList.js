import React, { PureComponent } from 'react';
import { connect } from 'dva';
import { Card, Form } from 'antd';
import PageHeaderWrapper from '@/components/PageHeaderWrapper';
import action from '../../utils/action';

@connect(({}) => ({}))
@Form.create()
class RoleTableList extends PureComponent {
  componentDidMount() {
    const { dispatch } = this.props;
    dispatch(action('permission/roles'));
  }

  render() {
    return (
      <PageHeaderWrapper title="角色列表">
        <Card bordered={false} />
      </PageHeaderWrapper>
    );
  }
}

export default RoleTableList;
