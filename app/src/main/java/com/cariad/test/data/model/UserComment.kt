package com.kumar.test.data.model

import com.cariad.test.data.model.CheckinStatusType
import com.cariad.test.data.model.CommentType
import com.cariad.test.data.model.UserX

data class UserComment(
    val ChargePointID: Int,
    val CheckinStatusType: CheckinStatusType,
    val CheckinStatusTypeID: Int,
    val Comment: String,
    val CommentType: CommentType,
    val CommentTypeID: Int,
    val DateCreated: String,
    val ID: Int,
    val IsActionedByEditor: Any,
    val Rating: Int,
    val RelatedURL: Any,
    val User: UserX,
    val UserName: String
)