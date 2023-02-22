<template>
  <div>
    <CarouselChart />
    <HomeIntroduction />
  </div>
</template>

<script>
import CarouselChart from '@/components/Home/CarouselChart.vue'
import HomeIntroduction from '@/components/Home/HomeIntroduction.vue'

export default {
  name: 'HomeView',
  components: {
    CarouselChart,
    HomeIntroduction
  }
}
</script>

<style scoped></style>
