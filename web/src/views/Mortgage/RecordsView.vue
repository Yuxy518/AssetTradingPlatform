<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：办理按揭贷款——办理进度
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
                                        <th scope="col">服务类型</th>
                                        <th scope="col">审核进度</th>
                                        <th scope="col">备注信息</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="(record, index) in records" :key="record.submitTime">
                                        <th scope="row">{{ index + 1 }}</th>
                                        <td>{{ record.submitTime }}</td>
                                        <td>{{ record.name1 }}</td>
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


import NavCom from '@/components/Mortgage/NavCom.vue';
import PicCom from '@/components/Mortgage/PicCom.vue';
import $ from 'jquery';
import { computed } from '@vue/reactivity';
import { useStore } from 'vuex';
import { ref } from 'vue';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);
        const records = ref([]);

        $.ajax({
            url: "http://127.0.0.1:3000/mortgage/record/",
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
            error(resp) {
                console.log(resp);
            }
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