<template>
    <div class="back">

        <!-- <div class="popup">
                <div aria-live="polite" aria-atomic="true" class="d-flex justify-content-center align-items-center w-100">
                    <div class="toast show" role="alert" aria-live="assertive" aria-atomic="true">
                        <div class="toast-header">
                            <strong class="me-auto">Bootstrap</strong>
                            <small>11 mins ago</small>
                            <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
                        </div>
                        <div class="toast-body">
                            Hello, world! This is a toast message.
                        </div>
                    </div>
                </div>
            </div> -->


        <div class="row">
            <div class="col-6 outer">
                <div class="card">
                    <div class="card-body">

                        <div class="row">
                            <div class="col-5 inner">
                                <form @submit.prevent="login">
                                    <div class="title">登 录</div>
                                    <div class="mb-3">
                                        <label for="username" class="form-label">用户名：</label>
                                        <input v-model="username" type="text" class="form-control" id="username">
                                    </div>
                                    <div class="mb-4">
                                        <label for="password" class="form-label">密码：</label>
                                        <input v-model="password" type="password" class="form-control" id="password">
                                    </div>
                                    <div v-if="error_message === 'success'" class="success">登录成功！</div>
                                    <div v-if="error_message == 'error'" class="error">用户名或密码错误！</div>
                                    <button type="submit" class="btn btn-primary mb-5 subBtn">提交</button>
                                </form>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import router from '@/router';
import { ref } from 'vue';
import { useStore } from 'vuex';

export default {
    setup() {
        const store = useStore();
        const username = ref("");
        const password = ref("");
        const error_message = ref("");

        const login = () => {
            error_message.value = "";
            store.dispatch("login", {
                username: username.value,
                password: password.value,

                success(resp) {
                    console.log('登录成功', resp);
                    error_message.value = "success";
                    // $('.toast').show();

                    setTimeout(() => {
                        router.push({ name: "HomeView" });
                    }, 1500);

                    store.dispatch('getInfo', {
                        success(resp) {
                            console.log('获取用户信息成功', resp);
                        },
                        error(resp) {
                            console.log('获取用户信息失败', resp);
                        }
                    })
                },
                error(resp) {
                    error_message.value = "error";
                    console.log("登录失败", resp);
                }
            });
        }

        return {
            username,
            password,
            error_message,
            login,
        }
    }
}
</script>

<style scoped>
.inner {
    margin: 0 auto;
}

.back {
    height: calc(100vh - 145px);
    background-image: url('@/assets/images/login.jpg');
    background-size: 100% 100%;
    position: relative;
}

.outer {
    margin: 0 auto;
}

.card {
    margin-top: 110px;
    background-color: rgb(232, 243, 253);
    border: 0px none rgba(100, 100, 100, 0);
    border-radius: 55px;
    box-shadow:
        inset 12px 12px 24px 0px rgba(239, 243, 255, 1),
        inset -16px -16px 16px 0px rgba(191, 209, 255, 1),
        15px 15px 16px 0px rgba(131, 154, 215, 1);
}

.title {
    font-size: 30px;
    margin: 10px;
    text-align: center;
    color: rgb(90, 90, 90);
}

.subBtn {
    width: 100%;
}

.success {
    color: green;
}

.error {
    color: red;
}

.popup {
    position: absolute;
    top: 20px;
    margin-left: calc(50vw - 180px);
}
</style>