<template>
    <div>
        <PicCom />
        <div class="container">
            <div class="position">
                位置：办理转按揭贷款——签订贷款合同
            </div>

            <hr>

            <div class="row">
                <div class="col-3">
                    <NavCom />
                </div>

                <div class="col-9">
                    <div class="card outer-card">
                        <div class="card-body">
                            <div class="card inner-card">
                                <div class="card-body inner-card-body">
                                    <form @submit.prevent="submit_info">
                                        <div class="row mb-4">
                                            <div class="col-6">
                                                <div class="form-floating">
                                                    <input type="text" class="form-control" id="floatingInput"
                                                        placeholder=" " v-model="serviceNum">
                                                    <label for="floatingInput">点击输入申请转按揭处理编号</label>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="row mb-4">
                                            <div class="col-8">
                                                <label for="formFileLg" class="form-label">选择按揭贷款合同</label>
                                                <input class="form-control form-control" id="formFileLg" type="file">
                                            </div>
                                        </div>
                                        <div class="row mb-5">
                                            <div class="col-8">
                                                备注信息
                                                <div class="accordion-body">
                                                    <textarea class="form-control" rows="3"
                                                        placeholder="如果有情况说明，可以在此填写(非必填)。" v-model="remarks"></textarea>
                                                </div>
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-primary">提交</button>
                                    </form>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import NavCom from '@/components/Mortgage/NavCom.vue';
import PicCom from '@/components/Mortgage/PicCom.vue';
import $ from 'jquery';
import { useStore } from 'vuex';
import { computed } from '@vue/reactivity';
import { ref } from 'vue';
import router from '@/router/index';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);

        const serviceNum = ref("");
        const remarks = ref("");

        const submit_info = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/mortgage/contract/",
                type: "post",
                data: {
                    userId: userId.value,
                    serviceNum: serviceNum.value,
                    remarks: remarks.value,
                },
                headers: {
                    Authorization: "Bearer " + token.value,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        alert("提交成功，正在跳转处理记录页面...");
                        router.push({ name: "Mortgage_RecordsView" });
                    }
                    else {
                        console.log(resp);
                    }
                },
                error(resp) {
                    console.log(resp);
                }
            });
        }

        return {
            serviceNum,
            remarks,
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

button {
    display: block;
    margin: 20px;
    margin-left: auto;
}

.outer-card {
    height: 50vh;
}

.inner-card {
    background-color: rgb(247, 247, 247);
    margin: 20px auto;
    width: 80%;
}

.inner-card-body {
    margin: 20px;
}
</style>