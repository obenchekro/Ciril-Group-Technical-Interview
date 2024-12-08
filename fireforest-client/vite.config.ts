import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';
import * as path from "node:path";

export default defineConfig({
    plugins: [vue()],
    resolve: {
        alias: {
            "@": path.resolve(__dirname, "./src"),
        },
    },
    root: '.',
    build: {
        outDir: 'dist',
        rollupOptions: {
            input: 'index.html',
        },
    },
    server: {
        proxy: {
            "/api": {
                target: "http://localhost:8080", // URL de votre backend
                changeOrigin: true,
            },
        },
    },
});
