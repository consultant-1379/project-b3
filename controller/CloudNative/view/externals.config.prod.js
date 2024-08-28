const externals = {
  apps: [{
    path: "app-1",
    entry: "App1"
  }],
  components: {
    default: [],
    shareable: [{
      path: "questions",
      entry: "Questions"
    }, {
      path: "sub-question",
      entry: "SubQuestion"
    }, {
      path: "landing_page",
      entry: "Landing_page"
    }]
  },
  panels: [],
  plugins: []
};

module.exports = externals;