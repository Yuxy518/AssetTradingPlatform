import $ from 'jquery'

export default ({
    state: {
        id: "",
        username: "",
        photo: "",
        token: "",
        is_login: false,
        is_admin: false,
    },
    getters: {
    },
    mutations: {
        updateUser(state, user) {
            state.id = user.userid;
            state.username = user.username;
            state.photo = user.photo;
            state.is_login = user.is_login;
            state.is_admin = user.is_admin;
        },

        updateToken(state, token) {
            state.token = token;
        },

        logout(state) {
            state.id = "";
            state.username = "";
            state.photo = "";
            state.is_login = false;
        }

    },
    actions: {
        login(context, data) {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/token/",
                type: "post",
                data: {
                    username: data.username,
                    password: data.password,
                },
                success(resp) {
                    localStorage.setItem("jwt_token", resp.jwt_token);
                    context.commit("updateToken", resp.jwt_token);
                    data.success(resp);
                },
                error(resp) {
                    data.error(resp);
                }
            });
        },

        getInfo(context, data) {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/info/",
                type: 'get',
                headers: {
                    Authorization: "Bearer " + context.state.token,
                },
                success(resp) {
                    context.commit("updateUser", {
                        ...resp,
                        is_login: true,
                    });
                    data.success(resp);
                },
                error(resp) {
                    data.error(resp);
                }
            });
        },

        logout(context) {
            localStorage.removeItem("jwt_token");
            context.commit("logout");
        }
    },
    modules: {
    }
})
