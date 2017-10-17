package com.one20.unisonui.recycler.model

/**
 * Model class for holding data to be displayed in a Single or Multi-line ViewHolder.
 */
class UnisonRecyclerItemModel {

    /**
     * Primary line of text
     */
    var primaryText: String

    /**
     * Secondary line of text
     */
    lateinit var secondaryText: String

    /**
     * Image resource
     */
    var imageRes: Int = 0


    /**
     * @param   primaryText Primary text string
     */
    constructor(primaryText: String) {
        this.primaryText = primaryText
    }

    /**
     * @param   primaryText     Primary text string
     * @param   secondaryText   Secondary text string
     */
    constructor(primaryText: String, secondaryText: String) {
        this.primaryText = primaryText
        this.secondaryText = secondaryText
    }

    /**
     * @param   primaryText     Primary text string
     * @param   imageRes        Image resource
     */
    constructor(primaryText: String, imageRes: Int) {
        this.primaryText = primaryText
        this.imageRes = imageRes
    }

    /**
     * @param   primaryText     Primary text string
     * @param   secondaryText   Secondary text string
     * @param   imageRes        Image resource
     */
    constructor(primaryText: String, secondaryText: String, imageRes: Int) {
        this.primaryText = primaryText
        this.secondaryText = secondaryText
        this.imageRes = imageRes
    }





}