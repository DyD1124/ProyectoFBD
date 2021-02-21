import { uploadSection } from './js/uploadMenu.js'
import { uploadOptions } from './js/options.js'
import { clickElements } from './js/sectionAdmin.js'
import { sectionUser } from './js/sectionUser.js'

const $type = document.querySelector('.type').value;
const $section = document.querySelector('.sectUno').className;

document.addEventListener('DOMContentLoaded', () => {
    uploadSection($type, $section)
    uploadOptions()
    clickElements()
    sectionUser()
})