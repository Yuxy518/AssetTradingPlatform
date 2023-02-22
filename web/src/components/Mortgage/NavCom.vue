<template>
    <div class="title">
        业务处理
    </div>
    <div class="card">
        <div class="card-body">
            <ul class="nav flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="https://www.creditchina.gov.cn/gerenxinyong/?navPage=10"
                        target="_blank">信用评估</a>
                </li>
                <hr>
                <li class="nav-item info">
                    <router-link :to="{ name: 'Mortgage_InfoView' }" class="nav-link">申请按揭贷款</router-link>
                </li>
                <hr>
                <li class="nav-item contract">
                    <router-link :to="{ name: 'Mortgage_ContractView' }" class="nav-link">提交贷款合同</router-link>
                </li>
                <hr>
                <li class="nav-item records">
                    <router-link :to="{ name: 'Mortgage_RecordsView' }" class="nav-link">我的办理记录</router-link>
                </li>
                <hr>
                <li class="nav-item">
                    <router-link :to="{ name: 'Default_ComplaintView' }" class="nav-link">异常反馈</router-link>
                </li>
            </ul>
        </div>
    </div>
</template>

<script>
import { useRoute } from 'vue-router';
import { computed } from '@vue/reactivity';
import $ from 'jquery';

export default {
    mounted() {
        const route = useRoute();
        const store_name = computed(() => route.name);
        if (store_name.value === "Mortgage_InfoView") {
            $(".info a").css("color", "#ba9a5b");
        } else if (store_name.value === "Mortgage_ContractView") {
            $(".contract a").css("color", "#ba9a5b");
        } else if (store_name.value === "Mortgage_RecordsView") {
            $(".records a").css("color", "#ba9a5b");
        }
    }
}
</script>

<style scoped>
.title {
    font-size: 32px;
    color: rgb(94, 94, 94);
    margin: 20px 20px;
}

.nav-item>a {
    font-size: 18px;
    font-weight: bolder;
    color: rgb(90, 90, 90);
    margin-left: 10px;
}
</style>