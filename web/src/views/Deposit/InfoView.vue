<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：交定金——交定金信息采集
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
                                <div class="accordion" id="accordionExample">
                                    <div class="accordion-item">
                                        <h2 class="accordion-header" id="headingOne">
                                            <button class="accordion-button" type="button" data-bs-toggle="collapse"
                                                data-bs-target="#collapseOne" aria-expanded="true"
                                                aria-controls="collapseOne">
                                                付款人信息
                                            </button>
                                        </h2>
                                        <div id="collapseOne" class="accordion-collapse collapse show"
                                            aria-labelledby="headingOne">
                                            <div class="accordion-body">
                                                <!-- body -->
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name1" class="form-label">付款人姓名</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name1"
                                                                v-model="payerName">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum1" class="form-label">付款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum1"
                                                                v-model="payerIdNum">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="accordion-item">
                                        <h2 class="accordion-header" id="headingThree">
                                            <button class="accordion-button collapsed" type="button"
                                                data-bs-toggle="collapse" data-bs-target="#collapseThree"
                                                aria-expanded="false" aria-controls="collapseThree">
                                                房产信息
                                            </button>
                                        </h2>
                                        <div id="collapseThree" class="accordion-collapse collapse"
                                            aria-labelledby="headingThree">
                                            <div class="accordion-body">
                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="RealPropertyNum" class="form-label">不动产权证明编号</label>
                                                        <input class="form-control" id="RealPropertyNum"
                                                            v-model="propertyNum"
                                                            placeholder="X（20XX）XX市XX区 不动产证明 第XXXXXX号">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="PropertyPic" class="form-label">房地产权证</label>
                                                        <input class="form-control" type="file" id="PropertyPic" multiple>
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="Contract" class="form-label">借款合同（抵押合同）</label>
                                                        <input class="form-control" type="file" id="Contract" multiple>
                                                    </div>
                                                </div>
                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="Buy" class="form-label">房屋买卖合同</label>
                                                        <input class="form-control" type="file" id="Buy" multiple>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="accordion-item">
                                        <h2 class="accordion-header" id="headingFour">
                                            <button class="accordion-button collapsed" type="button"
                                                data-bs-toggle="collapse" data-bs-target="#collapseFour"
                                                aria-expanded="false" aria-controls="collapseFour">
                                                支付信息
                                            </button>
                                        </h2>
                                        <div id="collapseFour" class="accordion-collapse collapse"
                                            aria-labelledby="headingFour">
                                            <div class="accordion-body">
                                                <div class="row mb-3">
                                                    <div class="col-8">
                                                        支付二维码
                                                    </div>
                                                    <div class="col-8 payment">
                                                        <img src="@/assets/images/payment.jpg" alt="">
                                                    </div>
                                                </div>
                                                <div class="row mb-5">
                                                    <div class="col-5">
                                                        <label for="amount" class="form-label">付款金额</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="amount"
                                                                v-model="mount">
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="accordion-item">
                                        <h2 class="accordion-header" id="headingFive">
                                            <button class="accordion-button collapsed" type="button"
                                                data-bs-toggle="collapse" data-bs-target="#collapseFive"
                                                aria-expanded="false" aria-controls="collapseFive">
                                                备注信息
                                            </button>
                                        </h2>
                                        <div id="collapseFive" class="accordion-collapse collapse"
                                            aria-labelledby="headingFive">
                                            <div class="accordion-body">
                                                <div class="row mb-5">
                                                    <div class="col-10">
                                                        <textarea class="form-control" rows="3"
                                                            placeholder="如果有情况说明，可以在此填写(非必填)。" v-model="remarks"></textarea>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <button type="submit" class="btn btn-primary subBtn">提交信息</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import PicCom from '@/components/Deposit/PicCom.vue'
import NavCom from '@/components/Deposit/NavCom.vue'
import { useStore } from 'vuex';
import $ from 'jquery';
import { ref } from 'vue';
import { computed } from '@vue/reactivity';
import router from '@/router/index';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);

        const payerName = ref("");
        const payerIdNum = ref("");
        const propertyNum = ref("");
        const mount = ref("");
        const remarks = ref("");

        const submit_info = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/deposit/info/",
                type: "post",
                data: {
                    userId: userId.value,
                    payerName: payerName.value,
                    payerIdNum: payerIdNum.value,
                    propertyNum: propertyNum.value,
                    mount: mount.value,
                    remarks: remarks.value,
                },
                headers: {
                    Authorization: "Bearer " + token.value,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        alert("提交成功，正在跳转办理进度页查看详情...");
                        router.push({ name: "Deposit_RecordsView" });
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
            payerName,
            payerIdNum,
            propertyNum,
            mount,
            remarks,
            submit_info
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

.accordion-body>.row {
    margin-left: 10px;
}

.col-form-label {
    padding-left: 0;
    padding-right: 0;
}

.label {
    display: inline;
}

.row {
    margin-top: 12px;
}

.payment {
    margin: 0 auto;
}

.payment img {
    width: 50%;
}
</style>