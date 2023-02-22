<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：办理转按揭——办理记录
            </div>

            <hr>

            <div class="row">
                <div class="col-3">
                    <NavCom />
                </div>
                <div class="col-9">
                    <div class="card">
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th scope="col">编号</th>
                                        <th scope="col">提交时间</th>
                                        <th scope="col">申请人</th>
                                        <th scope="col">申请服务编号</th>
                                        <th scope="col">提交类型</th>
                                        <th scope="col">审核进度</th>
                                        <th scope="col">备注信息</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="(record, index) in records" :key="record.submitTime">
                                        <th scope="row">{{ index + 1 }}</th>
                                        <td>{{ record.submitTime }}</td>
                                        <td>{{ record.name1 }} / {{ record.name2 }}</td>
                                        <td>{{ record.serviceNum }}</td>
                                        <td>{{ record.type }}</td>
                                        <td>{{ record.progress }}</td>
                                        <td>{{ record.remarks }}</td>
                                    </tr>
                                </tbody>
                            </table>
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
import $ from 'jquery';
import { useStore } from 'vuex';
import { computed } from '@vue/reactivity';
import { ref } from 'vue';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);
        const records = ref([]); //需要动态变化

        $.ajax({
            url: "http://127.0.0.1:3000/refinance/record/",
            type: "get",
            data: {
                userId: userId.value,
            },
            headers: {
                Authorization: "Bearer " + token.value,
            },
            success(resp) {
                records.value = JSON.parse(resp.list);
            },
        });

        return {
            records,
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
</style>