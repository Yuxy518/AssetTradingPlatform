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

                            <from>
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
                                                            <input type="text" class="form-control" id="name1">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row">
                                                    <div class="col-8">
                                                        <label for="idNum1" class="form-label">付款人身份证号</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="idNum1">
                                                        </div>
                                                    </div>
                                                </div>

                                                <div class="row mb-5">
                                                    <div class="col-8">
                                                        <label for="remarks" class="form-label">备注信息</label>
                                                        <div class="col-8">
                                                            <input type="text" class="form-control" id="remarks">
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
                                <button type="submit" class="btn btn-primary subBtn">提交信息</button>
                            </from>

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