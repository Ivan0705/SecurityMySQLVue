<template>
    <v-layout row>
        <v-text-field
                title="Введите сообщение"
                placeholder="Введите сообщение"
                v-model="text">
        </v-text-field>
        <v-btn @click="save" class="success" title="Добавить">
            Добавить
        </v-btn>
    </v-layout>
</template>

<script>
    import {sendMessage} from "../../utils/ws";

    export default {
        props: ['messages', 'messageAttr'],
        data() {
            return {
                text: '',
                id: ''
            }
        },
        watch: {
            messageAttr(newVal, oldVal) {
                this.text = newVal.text;
                this.id = newVal.id
            }
        },
        methods: {
            save() {
                sendMessage({id: this.id, text: this.text});
                this.text = '';
                this.id = '';
            }
        }
    }
</script>

<style>
</style>