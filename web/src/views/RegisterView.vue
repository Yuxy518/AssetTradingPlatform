<template>
    <div class="back">
        <div class="row">
            <div class="col-6 outer">
                <div class="card">
                    <div class="card-body">
                        <div class="row">
                            <div class="col-5 inner">
                                <form @submit.prevent="register">
                                    <div class="title">注 册</div>
                                    <div class="mb-3">
                                        <label for="username" class="form-label">起一个用户名：</label>
                                        <input v-model="username" type="text" class="form-control" id="username">
                                    </div>
                                    <div class="mb-3">
                                        <label for="password" class="form-label">设置密码：</label>
                                        <input v-model="password" type="password" class="form-control" id="password">
                                    </div>
                                    <div class="mb-4">
                                        <label for="confirm_password" class="form-label">再次输入密码：</label>
                                        <input v-model="confirm_password" type="password" class="form-control"
                                            id="confirm_password">
                                    </div>
                                    <div v-if="error_message === 'success'" class="success"> 注册成功！正在跳转登录页... </div>
                                    <div v-else-if="error_message !== ''" class="error"> {{ error_message }} </div>
                                    <button type="submit" class="btn btn-primary mb-5">提交</button>
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
import { ref } from 'vue';
import $ from 'jquery';
import router from '@/router';

export default {
    setup() {
        const username = ref("");
        const password = ref("");
        const confirm_password = ref("");
        const error_message = ref("");

        const register = () => {
            error_message.value = "";
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/register/",
                type: "post",
                data: {
                    username: username.value,
                    password: password.value,
                    confirm_password: confirm_password.value,
                },
                success(resp) {
                    error_message.value = resp.error_message;
                    if (error_message.value === "success") {
                        setTimeout(() => {
                            router.push({ name: "LoginView" });
                        }, 1500);
                    }
                },
            });
        }

        return {
            username,
            password,
            confirm_password,
            error_message,
            register,
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
}

.outer {
    margin: 0 auto;

}

.card {
    margin-top: 10vh;
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

button {
    width: 100%;
}

.success {
    color: green;
}

.error {
    color: red;
}
</style>