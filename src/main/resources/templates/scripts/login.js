
var app = new Vue({
    el:"#app",
    data:{
        username: "",
        pwd:""
    },
    methods: {
        onLogin : function() {
            console.log(this.username);
            console.log(this.pwd);


            // Make a request for a user with a given ID
            axios.get('/login?email=12345&password=123456')
              .then(function (response) {
                // handle success
                console.log(response);
              })
              .catch(function (error) {
                // handle error
                console.log(error);
              })
              .then(function () {
                // always executed
              });
        }
    }
})