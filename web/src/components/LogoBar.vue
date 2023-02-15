<template>
    <div class="container">
        <nav class="navbar navbar-expand-lg">
            <div class="container-fluid">
                <img src="https://www.cfae.cn/business/images/header/bj_icon.png" alt="" class="logo">
                <form class="d-flex right">
                    <input type="text" name="titless" class="seacher_ipt" value="" placeholder="全文检索">
                    <button class="btn btn-outline-success btn-sm" type="submit">serach</button>
                </form>
            </div>
        </nav>
    </div>


</template>

<script>
export default {

}
</script>

<style scoped>
.logo {
    width: 300px;
    margin: 10px 0;
}

.img {
    display: inline-block;
}

button {
    width: 60px;
    margin-left: 10px;
}

.right {
    margin-left: auto;
}

.seacher_ipt {
    width: 406px;
    line-height: 40px;
    height: 40px;
    padding-left: 14px;
    align-self: center;
    font-size: 14px;
    box-shadow: none;
    outline: none;
    resize: none;
    border: none;
    -webkit-tap-highlight-color: rgba(0, 0, 0, 0);
    border-radius: 4px;
    border: 1px solid #C6CBD9;
}
</style>