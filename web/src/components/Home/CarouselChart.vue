<template>
    <div>
        <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <ol class="carousel-indicators">
                <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"></li>
                <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></li>
                <!-- <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2"></li> -->
            </ol>
            <div class="carousel-inner">

                <div class="carousel-item active">
                    <img src="@/assets/images/Home/creative.jpg" class="d-block w-100">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>协作 · 创新</h1>
                        <p>Collaboration and Innovation</p>
                    </div>
                </div>

                <div class="carousel-item">
                    <img src="@/assets/images/Home/search.jpg" class="d-block w-100" alt="">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>便利 · 快捷</h1>
                        <p>Convenient and fast</p>
                    </div>
                </div>

                <!-- <div class="carousel-item">
                            <img src="@/assets/images/Home/job-5382501_1920.jpg" class="d-block w-100" alt="">
                            <div class="carousel-caption d-none d-md-block">
                                <h1>便利 · 快捷</h1>
                                <p>Convenient and fast</p>
                            </div>
                        </div> -->
            </div>
            <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </a>
        </div>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>
img {
    width: 100%;
    height: 100%;
}
</style>