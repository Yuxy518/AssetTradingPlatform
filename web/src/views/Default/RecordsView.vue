<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：违约处理——我的处理记录
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
                                        <th scope="col">提交时间</th>
                                        <th scope="col">身份证号</th>
                                        <th scope="col">问题描述</th>
                                        <th scope="col">处理进度</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr v-for="(record, index) in records" :key="record.submitTime">
                                        <th scope="row">{{ index + 1 }}</th>
                                        <td>{{ record.submitTime }}</td>
                                        <td>{{ record.userIdNum }}</td>
                                        <td>
                                            <div class="description">{{ record.description }}</div>
                                        </td>
                                        <td>{{ record.progress }}</td>
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
import PicCom from '@/components/Default/PicCom.vue';
import NavCom from '@/components/Default/NavCom.vue';
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
            url: "http://127.0.0.1:3000/default/record/",
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

.description {
    width: 300px;
    height: 70px;
    overflow: auto;
}
</style>