<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：交定金——支付定金
            </div>
            <hr>
            <div class="row">
                <div class="col-3">
                    <NavCom />
                </div>
                <div class="col-9">
                    <div class="card">
                        <div class="card-body">
                            获取卖方账户信息
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
</style>