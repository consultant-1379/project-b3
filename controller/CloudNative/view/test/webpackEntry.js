const context = require.context('../client', true, /.+-test\.js$/);
context.keys().forEach(context);
module.exports = context;
