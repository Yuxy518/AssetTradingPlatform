<template>
    <div>
        <PicCom />
        <div class="container">
            <div class="position">
                位置：办理转按揭——获取合同
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
                                    <label for="formFileLg" class="form-label">点击选择转按揭合同</label>
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
import NavCom from '@/components/Refinancing/NavCom.vue'
import PicCom from '@/components/Refinancing/PicCom.vue'
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