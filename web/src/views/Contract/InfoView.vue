<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：购房交易合同——信息采集
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
                                                卖方(甲方)信息
                                            </button>
                                        </h2>
                                        <div id="collapseOne" class="accordion-collapse collapse show"
                                            aria-labelledby="headingOne">
                                            <div class="accordion-body">
                                                <!-- body -->
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name1" class="form-label">卖方姓名</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name1"
                                                                v-model="sellerName">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum1" class="form-label">卖方身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum1"
                                                                v-model="sellerIdNum">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="idCardPic1" class="form-label">卖方和权利共有人身份证</label>
                                                        <input class="form-control" type="file" id="idCardPic1" multiple>
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
                                                买方(乙方)信息
                                            </button>
                                        </h2>
                                        <div id="collapseTwo" class="accordion-collapse collapse"
                                            aria-labelledby="headingTwo">
                                            <div class="accordion-body">
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name2" class="form-label">买方姓名</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name2"
                                                                v-model="buyerName">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum2" class="form-label">买方身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum2"
                                                                v-model="buyerIdNum">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idCardPic2" class="form-label">买方和权利共有人身份证</label>
                                                        <input class="form-control" type="file" id="idCardPic2" multiple>
                                                    </div>
                                                </div>

                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="HouseholdPic2" class="form-label">买方和权利共有人户口簿</label>
                                                        <input class="form-control" type="file" id="HouseholdPic2" multiple>
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
                                                购房交易合同
                                            </button>
                                        </h2>
                                        <div id="collapseFour" class="accordion-collapse collapse"
                                            aria-labelledby="headingFour">
                                            <div class="accordion-body">
                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="Buy" class="form-label">购房交易合同</label>
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
import NavCom from '@/components/Contract/NavCom.vue';
import PicCom from '@/components/Contract/PicCom.vue';
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

        const sellerName = ref("");
        const sellerIdNum = ref("");
        const buyerName = ref("");
        const buyerIdNum = ref("");
        const propertyNum = ref("");
        const remarks = ref("");

        const submit_info = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/contract/info/",
                type: "post",
                data: {
                    userId: userId.value,
                    sellerName: sellerName.value,
                    sellerIdNum: sellerIdNum.value,
                    buyerName: buyerName.value,
                    buyerIdNum: buyerIdNum.value,
                    propertyNum: propertyNum.value,
                    remarks: remarks.value,
                },
                headers: {
                    Authorization: "Bearer " + token.value,
                },
                success(resp) {
                    if (resp.error_message === 'success') {
                        alert("提交成功，正在跳转办理进度页查看详情...");
                        router.push({ name: "Contract_RecordsView" });
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
            sellerName,
            sellerIdNum,
            buyerName,
            buyerIdNum,
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