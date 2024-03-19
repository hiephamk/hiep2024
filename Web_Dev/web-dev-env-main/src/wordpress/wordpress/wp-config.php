<?php
/**
 * The base configuration for WordPress
 *
 * The wp-config.php creation script uses this file during the installation.
 * You don't have to use the web site, you can copy this file to "wp-config.php"
 * and fill in the values.
 *
 * This file contains the following configurations:
 *
 * * Database settings
 * * Secret keys
 * * Database table prefix
 * * ABSPATH
 *
 * @link https://wordpress.org/documentation/article/editing-wp-config-php/
 *
 * @package WordPress
 */

// ** Database settings - You can get this info from your web host ** //
/** The name of the database for WordPress */
define( 'DB_NAME', 'hiepdb' );

/** Database username */
define( 'DB_USER', 'hiepdb' );

/** Database password */
define( 'DB_PASSWORD', 'Hiep1981@' );

/** Database hostname */
define( 'DB_HOST', 'web-dev-env-main-db-1' );

/** Database charset to use in creating database tables. */
define( 'DB_CHARSET', 'utf8mb4' );

/** The database collate type. Don't change this if in doubt. */
define( 'DB_COLLATE', '' );

/**#@+
 * Authentication unique keys and salts.
 *
 * Change these to different unique phrases! You can generate these using
 * the {@link https://api.wordpress.org/secret-key/1.1/salt/ WordPress.org secret-key service}.
 *
 * You can change these at any point in time to invalidate all existing cookies.
 * This will force all users to have to log in again.
 *
 * @since 2.6.0
 */
define( 'AUTH_KEY',         'lX=>{Lwve&k!v,>Yi%kGIE,|D31(Lu7z8GB_@>wM-xOuZ,dm$=G^g>mU(RCxTN>o' );
define( 'SECURE_AUTH_KEY',  '4KM`,0?k1y+%z6O6! -2/{t_c?x1GpuEV8;Gb1x*l?xp}zFbQ4&-+Kc8fJ%5nf<{' );
define( 'LOGGED_IN_KEY',    'c,t9@#H1RP7=aRZe`wh!>:;^UJwVdS6w20e|%j8H`~!o .#o<<Mv,qDJk&+UuGzr' );
define( 'NONCE_KEY',        'UlN|_4@vdQV*=VP@$FKev{uBhJ-{{]/;5$UP)_A57b}/~!d9Y#|AxWnN)spMUT%I' );
define( 'AUTH_SALT',        '*i&kn4@khtN=*2kD|1[Wul]nx12ML3PM#S+A:85:$c`Xw0ibZf3/,&mOe~&{P% D' );
define( 'SECURE_AUTH_SALT', 't)F 7R>$5AI[QTw{jqw9r!Nk$3+Dhr~0+|67K4X_t1?ie!%AgIRlQQ6QX)Q?8U#U' );
define( 'LOGGED_IN_SALT',   'Y iH dFltZ<w6+rv~d&4,) MbN#^D3Y3^K!se+n,PtQV4;>pT84@pSh=)2zjjA#>' );
define( 'NONCE_SALT',       'aY#vG@;WPPQ^`:d#s_,Sfy)/SN;g},f1*RSr ml/&tNw/Xya+?uwiY 3~}eubBvY' );

/**#@-*/

/**
 * WordPress database table prefix.
 *
 * You can have multiple installations in one database if you give each
 * a unique prefix. Only numbers, letters, and underscores please!
 */
$table_prefix = 'wp_';

/**
 * For developers: WordPress debugging mode.
 *
 * Change this to true to enable the display of notices during development.
 * It is strongly recommended that plugin and theme developers use WP_DEBUG
 * in their development environments.
 *
 * For information on other constants that can be used for debugging,
 * visit the documentation.
 *
 * @link https://wordpress.org/documentation/article/debugging-in-wordpress/
 */
define( 'WP_DEBUG', false );

/* Add any custom values between this line and the "stop editing" line. */



/* That's all, stop editing! Happy publishing. */

/** Absolute path to the WordPress directory. */
if ( ! defined( 'ABSPATH' ) ) {
	define( 'ABSPATH', __DIR__ . '/' );
}

/** Sets up WordPress vars and included files. */
require_once ABSPATH . 'wp-settings.php';
