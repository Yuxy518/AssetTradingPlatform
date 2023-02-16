<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：交定金——获取认购书
            </div>
            <hr>
            <div class="row">
                <div class="col-3">
                    <NavCom />
                </div>
                <div class="col-9">
                    <div class="card">
                        <div class="card-body">
                            <form>
                                <div>
                                    <label for="formFileLg" class="form-label">点击选择交定金合同</label>
                                    <input class="form-control form-control-lg" id="formFileLg" type="file">
                                </div>
                                <button type="submit" class="btn btn-primary">提交</button>
                            </form>
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

button {
    display: block;
    margin: 20px;
    margin-left: auto;
}
</style>