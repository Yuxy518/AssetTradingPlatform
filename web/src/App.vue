<template>

  <router-view />
</template>

<script>
import $ from "jquery"

export default {
  setup() {
    $.ajax({
      url: "http://127.0.0.1:3000/user/account/token/",
      type: "post",
      data: {
        username: "yxy",
        password: "123",
      },
      success(resp) {
        console.log(resp);
      },
      error(resp) {
        console.log(resp);
      }
    });

    $.ajax({
      url: "http://127.0.0.1:3000/user/account/info/",
      type: "get",
      headers: {
        Authorization: "Bearer " + "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxY2FiMjI0OGJiMDE0MWJhOTFiMzQzMzBhYWQ1YzRiZSIsInN1YiI6IjEiLCJpc3MiOiJzZyIsImlhdCI6MTY3NjM4NDE4OSwiZXhwIjoxNjc3NTkzNzg5fQ.w0xPrRi-yR-PtZIBGogdk1tB5GVw2Y18FmBI0ZGXV7w",
      },
      success(resp) {
        console.log(resp);
      },
      error(resp) {
        console.log(resp);
      }
    })
  },
}

</script>

<style>

</style>
