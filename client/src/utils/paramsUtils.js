import omitBy from 'lodash/omitBy';

function removeEmpty(params) {
  if (!params) {
    return;
  }
  const newParams = JSON.parse(decodeURI(JSON.stringify(params)));
  return omitBy(newParams, (v) => !v || v === 'undefined' || v === '');
}

export default removeEmpty;
