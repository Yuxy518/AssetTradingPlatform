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

                            <from>
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
                                                            <input type="text" class="form-control" id="name1">
                                                        </div>
                                                    </div>
                                                    <div class="col-3">
                                                        <label for="gender1" class="form-label">借款人性别</label>
                                                        <div class="col-5">
                                                            <select id="gender1" class="form-select">
                                                                <option selected>男</option>
                                                                <option>女</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <label for="nation1" class="form-label">借款人民族</label>
                                                        <input type="text" class="form-control" id="nation1">
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum1" class="form-label">借款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum1">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idCardPic1" class="form-label">借款人和权利共有人身份证复印件</label>
                                                        <input class="form-control" type="file" id="idCardPic1" multiple>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8 mb-5">
                                                        <label for="capitalCardPic1" class="form-label">还款卡或还款存折复印件</label>
                                                        <input class="form-control" type="file" id="capitalCardPic1"
                                                            multiple>
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
                                                            <input type="text" class="form-control" id="name2">
                                                        </div>
                                                    </div>
                                                    <div class="col-3">
                                                        <label for="gender2" class="form-label">借款人性别</label>
                                                        <div class="col-5">
                                                            <select id="gender2" class="form-select">
                                                                <option selected>男</option>
                                                                <option>女</option>
                                                            </select>
                                                        </div>
                                                    </div>
                                                    <div class="col-2">
                                                        <label for="nation2" class="form-label">借款人民族</label>
                                                        <input type="text" class="form-control" id="nation2">
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum2" class="form-label">借款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum2">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idCardPic2" class="form-label">借款人和权利共有人身份证</label>
                                                        <input class="form-control" type="file" id="idCardPic2" multiple>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="HouseholdPic2" class="form-label">借款人和权利共有人户口簿</label>
                                                        <input class="form-control" type="file" id="HouseholdPic2" multiple>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="MarryPic2" class="form-label">借款人婚姻证明</label>
                                                        <input class="form-control" type="file" id="MarryPic2" multiple>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="IncomePic2" class="form-label">借款人和参贷人的收入证明</label>
                                                        <input class="form-control" type="file" id="IncomePic2" multiple>
                                                    </div>
                                                </div>

                                                <div class="row  mb-5">
                                                    <div class="col-8">
                                                        <label for="FundNum2" class="form-label">如公积金贷款另附公积金帐号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="FundNum2">
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
                                </div>
                                <button type="submit" class="btn btn-primary subBtn">提交申请</button>
                            </from>

                        </div>
                    </div>
                </div>
            </div>

        </div>
</div>
</template>

<script>
import NavCom from '@/components/Refinancing/NavCom.vue'
import PicCom from '@/components/Refinancing/PicCom.vue'
export default {
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