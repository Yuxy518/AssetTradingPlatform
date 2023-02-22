<template>
    <div class="title">
        业务处理
    </div>
    <div class="card">
        <div class="card-body">
            <ul class="nav flex-column">
                <li class="nav-item info">
                    <router-link :to="{ name: 'Default_ComplaintView' }" class="nav-link">投诉违约</router-link>
                </li>
                <hr>
                <li class="nav-item records">
                    <router-link :to="{ name: 'Default_RecordsView' }" class="nav-link">我的处理记录</router-link>
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
        if (store_name.value === "Default_ComplaintView") {
            $(".info a").css("color", "#ba9a5b");
        } else if (store_name.value === "Default_RecordsView") {
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