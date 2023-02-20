<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：办理转按揭——信息采集
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
                                                原借款人信息
                                            </button>
                                        </h2>
                                        <div id="collapseOne" class="accordion-collapse collapse show"
                                            aria-labelledby="headingOne">
                                            <div class="accordion-body">
                                                <!-- body -->
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name1" class="form-label">借款人姓名</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name1"
                                                                v-model="ori_name">
                                                        </div>
                                                    </div>

                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum1" class="form-label">借款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum1"
                                                                v-model="ori_idNum">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idCardPic1"
                                                            class="form-label ori_idCard">借款人和权利共有人身份证</label>
                                                        <input class="form-control" type="file" id="idCardPic1"
                                                            ref="ori_idCard" @change="upload_ori_idCard">
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8 mb-5">
                                                        <label for="capitalCardPic1" class="form-label">还款卡或还款存折</label>
                                                        <input class="form-control" type="file" id="capitalCardPic1"
                                                            ref="ori_cashCard" @change="upload_ori_cashCard">
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
                                                新借款人信息
                                            </button>
                                        </h2>
                                        <div id="collapseTwo" class="accordion-collapse collapse"
                                            aria-labelledby="headingTwo">
                                            <div class="accordion-body">
                                                <div class="row">
                                                    <div class="col-5">
                                                        <label for="name2" class="form-label">借款人姓名</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="name2"
                                                                v-model="new_name">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum2" class="form-label">借款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum2"
                                                                v-model="new_idNum">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idCardPic2" class="form-label">借款人和权利共有人身份证</label>
                                                        <input class="form-control" type="file" id="idCardPic2"
                                                            ref="new_idCard" @change="upload_new_idCard">
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="HouseholdPic2" class="form-label">借款人和权利共有人户口簿</label>
                                                        <input class="form-control" type="file" id="HouseholdPic2"
                                                            ref="new_householder" @change="upload_new_householder">
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="MarryPic2" class="form-label">借款人婚姻证明</label>
                                                        <input class="form-control" type="file" id="MarryPic2"
                                                            ref="new_marryProve" @change="upload_new_marryProve">
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="IncomePic2" class="form-label">借款人和参贷人的收入证明</label>
                                                        <input class="form-control" type="file" id="IncomePic2"
                                                            ref="new_incomeProve" @change="upload_new_incomeProve">
                                                    </div>
                                                </div>

                                                <div class="row  mb-5">
                                                    <div class="col-8">
                                                        <label for="FundNum2" class="form-label">如公积金贷款另附公积金帐号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="FundNum2"
                                                                v-model="new_fundNum">
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
                                                            v-model="realPropertyNum"
                                                            placeholder="X（20XX）XX市XX区 不动产证明 第XXXXXX号">
                                                    </div>
                                                </div>


                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="PropertyPic" class="form-label">房地产权证</label>
                                                        <input class="form-control" type="file" id="PropertyPic"
                                                            ref="property">
                                                    </div>
                                                </div>
                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="Contract" class="form-label">借款合同（抵押合同）</label>
                                                        <input class="form-control" type="file" id="Contract"
                                                            ref="loanContract">
                                                    </div>
                                                </div>
                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="Buy" class="form-label">房屋买卖合同</label>
                                                        <input class="form-control" type="file" id="Buy" ref="sellContract">
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
                                                备注信息
                                            </button>
                                        </h2>
                                        <div id="collapseFour" class="accordion-collapse collapse"
                                            aria-labelledby="headingFour">
                                            <div class="accordion-body">
                                                <div class="row mb-5">
                                                    <div class="col-10">
                                                        <textarea class="form-control" rows="3"
                                                            placeholder="如果有情况说明，可以在此填写(非必填)。" v-model="remark"></textarea>
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
import NavCom from '@/components/Refinancing/NavCom.vue';
import PicCom from '@/components/Refinancing/PicCom.vue';
import { ref } from 'vue';
import $ from 'jquery';
import { useStore } from 'vuex';
import { computed } from '@vue/reactivity';
import router from '@/router/index';

export default {
    setup() {
        const ori_name = ref("");
        const ori_idNum = ref("");
        const new_name = ref("");
        const new_idNum = ref("");
        const new_fundNum = ref("");
        const realPropertyNum = ref("");
        const remark = ref("");

        const store = useStore();
        const userId = computed(() => store.state.user.id); //取值用.value
        const token = computed(() => store.state.user.token);

        const submit_info = () => {
            $.ajax({
                url: "http://127.0.0.1:3000/refinance/info/",
                type: "post",
                data: {
                    userId: userId.value,
                    oriName: ori_name.value,
                    oriIdNum: ori_idNum.value,
                    newName: new_name.value,
                    newIdNum: new_idNum.value,
                    fundNum: new_fundNum.value,
                    realPropertyNum: realPropertyNum.value,
                    remarks: remark.value,
                },
                headers: {
                    Authorization: "Bearer " + token.value,
                },
                success(resp) {
                    if (resp.error_message === "success") {
                        alert("申请转按揭成功！正在跳转'我的办理进度'页面查看详情...");
                        router.push({ name: "Refinancing_RecordsView" });
                    }
                    else {
                        alert("申请转按揭失败，" + resp.error_message);
                    }
                },
                error(resp) {
                    alert("后端问题", resp);
                }
            });
        }

        return {
            ori_name,
            ori_idNum,
            new_name,
            new_idNum,
            new_fundNum,
            realPropertyNum,
            remark,
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