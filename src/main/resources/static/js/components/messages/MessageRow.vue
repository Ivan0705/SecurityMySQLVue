<template>
    <v-card class="my-2">
        <v-card-text primary-title>
            <i>({{ message.id }})</i>
            {{ message.text }}
        </v-card-text>
        <v-card-actions>
            <div>
                <v-btn value="Edit" @click="edit" small flat round title="Редактировать">
                    <v-icon color="blue">edit</v-icon>
                </v-btn>
            </div>
            <div>
                <v-btn icon @click="del" small title="Удалить">
                    <v-icon color="red">delete</v-icon>
                </v-btn>
            </div>
        </v-card-actions>
    </v-card>
</template>

<script>
    export default {
        props: ['message', 'editMessage', 'deleteMessage', 'messages'],
        methods: {
            edit() {
                this.editMessage(this.message)
            },
            del() {
                this.deleteMessage(this.message)
            }
        }
    }
</script>
<style>
</style>