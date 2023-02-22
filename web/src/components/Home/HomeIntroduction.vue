<template>
    <div class="container back">
        <div class="row">
            <div class="col-3">
                <div class="function">
                    <img src="@/assets/images/Home/icon-1.png" alt="">
                    <p>办理转按揭</p>
                    <div class="col-8 inner">

                        <router-link :to="{ name: 'Refinancing_InfoView' }" target="_blank">
                            <div class="card">申请转按揭</div>
                        </router-link>

                        <router-link :to="{ name: 'Refinancing_ContractView' }" target="_blank">
                            <div class="card">提交转按揭合同</div>
                        </router-link>

                        <router-link :to="{ name: 'Refinancing_RecordsView' }" target="_blank">
                            <div class="card">我的办理记录</div>
                        </router-link>
                    </div>

                </div>
            </div>
            <div class="col-3">
                <div class="function">
                    <img src="@/assets/images/Home/icon-2.png" width="70px" alt="">
                    <p>交定金</p>
                    <div class="col-8 inner">
                        <router-link :to="{ name: 'Deposit_InfoView' }" target="_blank">
                            <div class="card">交定金信息采集</div>
                        </router-link>
                        <router-link :to="{ name: 'Deposit_RecordsView' }" target="_blank">
                            <div class="card">我的办理记录</div>
                        </router-link>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="function">
                    <div class="col-8 inner">
                        <img src="@/assets/images/Home/icon-3.png" width="70px" alt="">
                        <p>购房交易合同</p>
                        <router-link :to="{ name: 'LoginView' }" target="_blank">
                            <div class="card">信用评估</div>
                        </router-link>
                        <router-link :to="{ name: 'Contract_InfoView' }" target="_blank">
                            <div class="card">提交交易合同</div>
                        </router-link>
                        <router-link :to="{ name: 'Contract_recordsView' }" target="_blank">
                            <div class="card">我的办理记录</div>
                        </router-link>
                    </div>
                </div>
            </div>
            <div class="col-3">
                <div class="function">
                    <div class="col-8 inner">
                        <img src="@/assets/images/Home/icon-4.png" width="70px" alt="">
                        <p>办理按揭贷款</p>
                        <router-link :to="{ name: 'LoginView' }" target="_blank">
                            <div class="card">信用评估</div>
                        </router-link>
                        <router-link :to="{ name: 'Mortgage_InfoView' }" target="_blank">
                            <div class="card">申请按揭贷款</div>
                        </router-link>
                        <router-link :to="{ name: 'Mortgage_ContractView' }" target="_blank">
                            <div class="card">提交贷款合同</div>
                        </router-link>
                        <router-link :to="{ name: 'Mortgage_RecordsView' }" target="_blank">
                            <div class="card">我的办理记录</div>
                        </router-link>
                    </div>
                </div>
            </div>

        </div>
    </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.back {
    margin-top: 8vh;
    height: 35vh;
}

.function {
    text-align: center;
}

p {
    margin-top: 10px;
}

.card {
    margin-bottom: 5px;
    padding: 5px;
}

.card:hover {
    background-color: rgb(250, 243, 213);
}

.inner {
    margin: 0 auto;
}

img {
    width: 70px;
}

a {
    text-decoration: none;
    color: rgb(97, 97, 97);
}
</style>