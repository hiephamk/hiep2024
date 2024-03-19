<?php
# Generated by the protocol buffer compiler.  DO NOT EDIT!
# source: google/ads/googleads/v14/errors/currency_error.proto

namespace Google\Ads\GoogleAds\V14\Errors\CurrencyErrorEnum;

use UnexpectedValueException;

/**
 * Enum describing possible currency errors.
 *
 * Protobuf type <code>google.ads.googleads.v14.errors.CurrencyErrorEnum.CurrencyError</code>
 */
class CurrencyError
{
    /**
     * Enum unspecified.
     *
     * Generated from protobuf enum <code>UNSPECIFIED = 0;</code>
     */
    const UNSPECIFIED = 0;
    /**
     * The received error code is not known in this version.
     *
     * Generated from protobuf enum <code>UNKNOWN = 1;</code>
     */
    const UNKNOWN = 1;
    /**
     * Bid must be a multiple of billable unit.
     *
     * Generated from protobuf enum <code>VALUE_NOT_MULTIPLE_OF_BILLABLE_UNIT = 2;</code>
     */
    const VALUE_NOT_MULTIPLE_OF_BILLABLE_UNIT = 2;

    private static $valueToName = [
        self::UNSPECIFIED => 'UNSPECIFIED',
        self::UNKNOWN => 'UNKNOWN',
        self::VALUE_NOT_MULTIPLE_OF_BILLABLE_UNIT => 'VALUE_NOT_MULTIPLE_OF_BILLABLE_UNIT',
    ];

    public static function name($value)
    {
        if (!isset(self::$valueToName[$value])) {
            throw new UnexpectedValueException(sprintf(
                    'Enum %s has no name defined for value %s', __CLASS__, $value));
        }
        return self::$valueToName[$value];
    }


    public static function value($name)
    {
        $const = __CLASS__ . '::' . strtoupper($name);
        if (!defined($const)) {
            throw new UnexpectedValueException(sprintf(
                    'Enum %s has no value defined for name %s', __CLASS__, $name));
        }
        return constant($const);
    }
}

// Adding a class alias for backwards compatibility with the previous class name.
class_alias(CurrencyError::class, \Google\Ads\GoogleAds\V14\Errors\CurrencyErrorEnum_CurrencyError::class);

