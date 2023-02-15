<template>
    <div>
        <div id="carouselExampleCaptions" class="carousel slide carousel-fade" data-bs-ride="carousel">
            <ol class="carousel-indicators">
                <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="0" class="active"></li>
                <!-- <li data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1"></li> -->
            </ol>
            <div class="carousel-inner">

                <div class="carousel-item active">
                    <img src="@/assets/images/CarouseChart1.png" class="d-block w-100">
                    <div class="carousel-caption d-none d-md-block">
                        <h1>First slide label</h1>
                        <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
                    </div>
                </div>

                <!-- <div class="carousel-item">
                    <img src="https://www.cfae.cn/static//images/12.jpg" class="d-block w-100" alt="">
                    <div class="carousel-caption d-none d-md-block">
                        <h5>Second slide label</h5>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
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

</style>