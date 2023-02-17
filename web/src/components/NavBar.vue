<template>
    <div class="back">
        <div class="container">
            <ul class="nav">
                <li class="nav-li nav-1"><router-link :class="route_name == 'HomeView' ? 'highlight' : ''"
                        :to="{ name: 'HomeView' }">首页</router-link>
                </li>
                <!-- 转按揭 -->
                <li class="nav-li nav-2"><router-link :class="(route_name == 'Refinancing_InfoView' ||
                    route_name == 'Refinancing_ContractView' || route_name == 'Refinancing_RecordsView')
                    ? 'highlight' : ''" :to="{
        name: 'Refinancing_InfoView'
    }">办理转按揭</router-link>
                    <ul class="dorp-box d-2">
                        <li class="drop-li"><router-link :to="{ name: 'Refinancing_InfoView' }">转按揭信息采集</router-link>
                        </li>
                        <li class="drop-li"><router-link :to="{ name: 'Refinancing_ContractView' }">获取转按揭合同</router-link>
                        </li>
                        <li class="drop-li"><router-link :to="{ name: 'Refinancing_RecordsView' }">我的办理记录</router-link>
                        </li>
                        <li class="drop-li"><router-link :to="{ name: 'FeedbackView' }">异常反馈</router-link></li>
                    </ul>
                </li>

                <!-- 交定金 -->
                <li class="nav-li nav-3"><router-link :class="(route_name == 'Deposit_InfoView' || route_name == 'Deposit_ContractView'
                    || route_name == 'Deposit_PayView' || route_name == 'Deposit_RecordsView') ? 'highlight' : ''"
                        :to="{ name: 'Deposit_InfoView' }">交定金</router-link>
                    <ul class="dorp-box d-3">
                        <li class="drop-li"><router-link :to="{ name: 'Deposit_InfoView' }">交定金信息采集</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Deposit_ContractView' }">提交认购书</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Deposit_PayView' }">支付定金</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Deposit_RecordsView' }">我的办理记录</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'FeedbackView' }">异常反馈</router-link></li>
                    </ul>
                </li>
                <!-- 签订购房交易合同 -->
                <li class="nav-li nav-4"><router-link :class="(route_name == 'Contract_InfoView' || route_name == 'Contract_ContractView'
                    || route_name == 'Contract_recordsView') ? 'highlight' : ''"
                        :to="{ name: 'Contract_InfoView' }">购房交易合同</router-link>
                    <ul class="dorp-box d-4">
                        <li class="drop-li"><a href="https://www.creditchina.gov.cn/gerenxinyong/?navPage=10"
                                target="_blank">信用评估</a></li>
                        <li class="drop-li"><router-link :to="{ name: 'Contract_InfoView' }">信息采集</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Contract_ContractView' }">签订交易合同</router-link>
                        </li>
                        <li class="drop-li"><router-link :to="{ name: 'Contract_recordsView' }">我的办理记录</router-link>
                        </li>
                        <li class="drop-li"><router-link :to="{ name: 'FeedbackView' }">异常反馈</router-link></li>
                    </ul>
                </li>
                <!-- 办理按揭贷款 -->
                <li class="nav-li nav-5"><router-link
                        :class="(route_name == 'Mortgage_ContractView' || route_name == 'Mortgage_RecordsView' || route_name == 'Mortgage_InfoView') ? 'highlight' : ''"
                        :to="{ name: 'Mortgage_ContractView' }">办理按揭贷款</router-link>
                    <ul class="dorp-box d-5">
                        <li class="drop-li"><a href="https://www.creditchina.gov.cn/gerenxinyong/?navPage=10"
                                target="_blank">信用评估</a></li>
                        <li class="drop-li"><router-link :to="{ name: 'Mortgage_InfoView' }">选择贷款类型</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Mortgage_ContractView' }">签订合同</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Mortgage_RecordsView' }">我的办理记录</router-link>
                        </li>
                        <li class="drop-li"><router-link :to="{ name: 'FeedbackView' }">异常反馈</router-link></li>
                    </ul>
                </li>
                <!-- 违约处理 -->
                <li class="nav-li nav-6"><router-link
                        :class="(route_name == 'Default_ComplaintView' || route_name == 'Default_RecordsView') ? 'highlight' : ''"
                        :to="{ name: 'Default_ComplaintView' }">违约处理</router-link>
                    <ul class="dorp-box d-6">
                        <li class="drop-li"><router-link :to="{ name: 'Default_ComplaintView' }">投诉违约</router-link></li>
                        <li class="drop-li"><router-link :to="{ name: 'Default_RecordsView' }">我的处理记录</router-link></li>
                    </ul>
                </li>
                <!-- 个人主页 -->
                <li class="nav-li dropdown" v-if="!$store.state.user.is_login">
                    <a class="nav-link dropdown-toggle" role="button" data-bs-toggle="dropdown">
                        未登录
                    </a>
                    <ul class="dropdown-menu">
                        <li><router-link class="dropdown-item" :to="{ name: 'LoginView' }">登录</router-link> </li>
                        <li><router-link class="dropdown-item" :to="{ name: 'RegisterView' }">注册账号</router-link> </li>
                    </ul>
                </li>

                <li class="nav-li dropdown" v-else>
                    <a class="nav-link dropdown-toggle infoBtn" role="button" data-bs-toggle="dropdown">
                        <img class="userPhoto" :src=$store.state.user.photo alt="">
                        <span class="userName">{{ $store.state.user.username }}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <li><router-link class="dropdown-item" :to="{ name: '' }">我的业务进度</router-link> </li>
                        <li><span class="dropdown-item" style="cursor: pointer" @click="logout">退出登录</span></li>
                    </ul>
                </li>
            </ul>
        </div>
</div>
</template>

<script>
import $ from "jquery";
import { useRoute } from "vue-router";
import { computed } from "vue";
import { useStore } from "vuex";

window.onload = function () {
    $(".nav-1").mouseover(function () {
        $('.d-1').show();
    }); $(".nav-1").mouseout(function () {
        $('.d-1').hide();
    });
    $(".nav-2").mouseover(function () {
        $('.d-2').show();
    }); $(".nav-2").mouseout(function () {
        $('.d-2').hide();
    });
    $(".nav-3").mouseover(function () {
        $('.d-3').show();
    }); $(".nav-3").mouseout(function () {
        $('.d-3').hide();
    });
    $(".nav-4").mouseover(function () {
        $('.d-4').show();
    }); $(".nav-4").mouseout(function () {
        $('.d-4').hide();
    });
    $(".nav-5").mouseover(function () {
        $('.d-5').show();
    }); $(".nav-5").mouseout(function () {
        $('.d-5').hide();
    });
    $(".nav-6").mouseover(function () {
        $('.d-6').show();
    }); $(".nav-6").mouseout(function () {
        $('.d-6').hide();
    });
    $(".nav-7").mouseover(function () {
        $('.d-7').show();
    }); $(".nav-7").mouseout(function () {
        $('.d-7').hide();
    });
}
export default {
    setup() {
        const route = useRoute();
        const route_name = computed(() => route.name);

        const store = useStore();

        const logout = () => {
            store.dispatch("logout");
            alert("您已退出登录！");
        }

        return {
            route_name,
            logout,
        }
    }
}
</script>

<style scoped>
.nav-li>a {
    font-size: 16px !important;
}

.back {
    background-color: #1a3f89;
    height: 52px;
}

.nav {
    position: relative;
}

.nav-li {
    width: 180px;
    text-align: center;
}

.nav-li>a {
    padding: 16px 0;
    margin: 0 auto;
    color: #eeeeee;
    display: block;
    text-decoration: none;
    font-size: 14px;
    line-height: 18px;
}

.nav-li>a:hover {
    background-color: #1d498d;
    border-bottom: #ffd480 solid 2px;
}

.highlight {
    background-color: #1d498d;
    border-bottom: #ffd480 solid 2px;
}

.dorp-box {
    position: absolute;
    top: 52px;
    background-color: #ffffff;
    width: 180px;
    display: none;
    box-shadow: 0 2px 2px gray;
    z-index: 2;
}

.drop-li a {
    padding: 8px 20px;
    color: #414141;
    display: block;
    font-size: 13px;
    text-decoration: none;
    position: relative;
    right: 20px;
}

.drop-li :hover {
    background-color: rgb(246, 243, 227);
}

.drop-li {
    margin: 8px 0;
    list-style-type: none;
}

.infoBtn {
    position: relative;
}

.userPhoto {
    position: absolute;
    width: 35px;
    top: 10px;
    left: 20px;
    border-radius: 50%;
}

.userName {
    position: relative;
}
</style>