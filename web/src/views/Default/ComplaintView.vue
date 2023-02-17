<template>
    <div>
        <PicCom />

        <div class="container">
            <div class="position">
                位置：违约处理——投诉违约
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
                                <div class="mb-4">
                                    <label for="idNum" class="form-label">请输入您的身份证号</label>
                                    <input type="text" class="form-control" id="idNum" placeholder="请输入18位数字身份证号">
                                </div>
                                <div class="mb-5">
                                    <label for="describe" class="form-label"> 请描述您遇到的问题 </label>
                                    <textarea class="form-control" id="describe" rows="3"></textarea>
                                </div>
                                <button type="submit" class="btn btn-primary subBtn">提交</button>
                            </form>

                        </div>
                    </div>
                </div>
            </div>

        </div>
</div>
</template>

<script>
import NavCom from '@/components/Default/NavCom.vue'
import PicCom from '@/components/Default/PicCom.vue'
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

.subBtn {
    display: block;
    margin: 30px;
    margin-left: auto;
}

.row {
    margin-top: 12px;
}
</style>