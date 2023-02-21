<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：办理按揭贷款——信息采集与选择贷款
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
                                                贷款人信息
                                            </button>
                                        </h2>
                                        <div id="collapseOne" class="accordion-collapse collapse show"
                                            aria-labelledby="headingOne">
                                            <div class="accordion-body">
                                                <!-- body -->
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name1" class="form-label">贷款人姓名</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name1"
                                                                v-model="name">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum1" class="form-label">贷款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum1"
                                                                v-model="idNum">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idCardPic1" class="form-label">贷款人和权利共有人身份证</label>
                                                        <input class="form-control" type="file" id="idCardPic1" multiple>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="MarryPic2" class="form-label">借款人婚姻证明</label>
                                                        <input class="form-control" type="file" id="MarryPic2" multiple>
                                                    </div>
                                                </div>

                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="IncomePic2" class="form-label">借款人和参贷人的收入证明</label>
                                                        <input class="form-control" type="file" id="IncomePic2" multiple>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="accordion-item">
                                        <h2 class="accordion-header" id="headingTwo">
                                            <button class="accordion-button collapsed" type="button"
                                                data-bs-toggle="collapse" data-bs-target="#collapseTwo"
                                                aria-expanded="false" aria-controls="collapseTwo">
                                                贷款银行信息
                                            </button>
                                        </h2>

                                        <div id="collapseTwo" class="accordion-collapse collapse"
                                            aria-labelledby="headingTwo">
                                            <div class="accordion-body">
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name1" class="form-label">贷款银行名称</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name1"
                                                                v-model="bankName">
                                                        </div>
                                                    </div>
                                                    <div class="row">
                                                        <div class="col-5">
                                                            <label for="num2" class="form-label">贷款银行联行号</label>
                                                            <div class="col-8 mb-5">
                                                                <input type="text" class="form-control" id="num2"
                                                                    v-model="bankId">
                                                            </div>
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
                                <button type="submit" class="btn btn-primary subBtn">提交申请</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>

import NavCom from '@/components/Mortgage/NavCom.vue'
import PicCom from '@/components/Mortgage/PicCom.vue'
import $ from 'jquery';
import { computed } from '@vue/reactivity';
import { useStore } from 'vuex';
import { ref } from 'vue';
import router from '@/router/index';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);

        const name = ref("");
        const idNum = ref("");
        const bankName = ref("");
        const bankId = ref("");
        const propertyNum = ref("");
        const remarks = ref("");

        const submit_info = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/mortgage/info/",
                type: "post",
                data: {
                    userId: userId.value,
                    name: name.value,
                    idNum: idNum.value,
                    bankName: bankName.value,
                    bankId: bankId.value,
                    propertyNum: propertyNum.value,
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
                },
                error(resp) {
                    console.log(resp);
                }
            });
        }

        return {
            name,
            idNum,
            bankName,
            bankId,
            propertyNum,
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
</style>