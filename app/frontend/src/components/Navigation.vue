<script setup lang="ts">
import Logo from "@/components/Logo.vue";
import Title from "@/components/Title.vue";

const tabs = [
  {title: "Startseite", route: "startseite"},
  {title: "Projekte", route: "startseite"},
  {title: "Kontakt", route: "startseite"},
]
</script>

<template>
  <nav>
    <NuxtLink>
      <Logo/>
      <Title/>
    </NuxtLink>
    <div>
      <NuxtLink v-for="button in tabs" :key="button.title" :to="button.route">{{ button.title }}</NuxtLink>
    </div>
  </nav>
</template>

<style scoped>
nav {
  width: 100%;
  position: fixed;
  top: 0;
}
</style>