<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：违约处理——投诉违约
            </div>
            <hr>
            <div class="row">
                <div class="col-3">
                    <NavCom />
                </div>

                <div class="col-9">
                    <div class="card">
                        <div class="card-body">

                            <form @submit.prevent="submit_info">
                                <div class="mb-4">
                                    <label for="name" class="form-label">请输入您的姓名</label>
                                    <input type="text" class="form-control" id="name" placeholder="请输入姓名"
                                        v-model="userName">
                                </div>
                                <div class="mb-4">
                                    <label for="idNum" class="form-label">请输入您的身份证号</label>
                                    <input type="text" class="form-control" id="idNum" placeholder="请输入18位数字身份证号"
                                        v-model="userIdNum">
                                </div>
                                <div class="mb-5">
                                    <label for="describe" class="form-label"> 请描述您遇到的问题 </label>
                                    <textarea class="form-control" id="describe" rows="3" v-model="description"></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary subBtn">提交</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
import NavCom from '@/components/Default/NavCom.vue';
import PicCom from '@/components/Default/PicCom.vue';
import $ from 'jquery';
import { computed } from '@vue/reactivity';
import { useStore } from 'vuex';
import { ref } from 'vue';
import router from '@/router';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);

        const userName = ref("");
        const userIdNum = ref("");
        const description = ref("");

        const submit_info = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/default/complain/",
                type: "post",
                data: {
                    userId: userId.value,
                    userName: userName.value,
                    userIdNum: userIdNum.value,
                    description: description.value,
                },
                headers: {
                    Authorization: "Bearer " + token.value,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        alert("提交成功，正在跳转办理进度页查看详情...");
                        router.push({ name: "Default_RecordsView" });
                    }
                    else {
                        alert("提交失败，" + resp.error_message);
                    }
                },
                error(resp) {
                    console.log(resp);
                }
            });
        }

        return {
            userName,
            userIdNum,
            description,
            submit_info,
        }
    },

    components: {
        PicCom,
        NavCom,
    }
}
</script>

<style scoped>
.position {
    margin: 15px 10px;
}

.subBtn {
    display: block;
    margin: 30px;
    margin-left: auto;
}

.row {
    margin-top: 12px;
}

.card-body {
    padding: 30px;
}
</style>