<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：交定金——记录
            </div>
            <hr>
            <div class="row">
                <div class="col-3">
                    <NavCom />
                </div>
                <div class="col-9">
                    <div class="card">
                        <div class="card-body">
                            <table class="table">
                                <thead>
                                    <tr>
                                        <th scope="col">编号</th>
                                        <th scope="col">支付时间</th>
                                        <th scope="col">支付人姓名</th>
                                        <th scope="col">支付人身份证号</th>
                                        <th scope="col">房产证明编号</th>
                                        <th scope="col">支付金额</th>
                                        <th scope="col">审核进度</th>
                                        <th scope="col">备注</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="(record, index) in records" :key="record.submitTime">
                                        <th scope="row">{{ index + 1 }}</th>
                                        <td>{{ record.submitTime }}</td>
                                        <td>{{ record.payerName }}</td>
                                        <td>{{ record.payerIdNum }}</td>
                                        <td>{{ record.propertyNum }}</td>
                                        <td>{{ record.mount }}</td>
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
import PicCom from '@/components/Deposit/PicCom.vue';
import NavCom from '@/components/Deposit/NavCom.vue';
import $ from 'jquery';
import { useStore } from 'vuex';
import { computed } from '@vue/reactivity';
import { ref } from 'vue';

export default {
    setup() {
        const store = useStore();
        const userId = computed(() => store.state.user.id);
        const token = computed(() => store.state.user.token);
        const records = ref([]);

        $.ajax({
            url: "http://127.0.0.1:3000/deposit/record/",
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